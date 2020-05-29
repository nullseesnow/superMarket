package com.six;

import com.six.utils.GsonUtils;
import com.six.utils.HttpUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * ��������
 */

/**
 * ��������
 */
public class FaceSearch {

    /**
     * ��Ҫ��ʾ���������蹤����
     * FileUtil,Base64Util,HttpUtil,GsonUtils���
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * ����
     */
    public static String search(String image) {
        // ����url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/search";
        try {
            Map<String, Object> map = new HashMap<>();
            //ͼƬ��base64���� �������ͼƬ��base64����
            map.put("image", image);
            //�������õ� ������ ���ù�
            map.put("liveness_control", "NORMAL");
            //ָ�����е� grop�е����� hdf:�������
            map.put("group_id_list", "hdf");
            //ͼƬ���� ת������base64
            map.put("image_type", "BASE64");
            //ͼƬ��������
            map.put("quality_control", "LOW");

            String param = GsonUtils.toJson(map);

            // ע�������Ϊ�˼򻯱���ÿһ������ȥ��ȡaccess_token�����ϻ���access_token�й���ʱ�䣬 �ͻ��˿����л��棬���ں����»�ȡ��
            String accessToken = AuthService.getAuth();


            String result = HttpUtil.post(url, accessToken, "application/json", param);
            String score = result.split(",")[9].split(":")[1];
            System.out.println(result);
            return score;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}