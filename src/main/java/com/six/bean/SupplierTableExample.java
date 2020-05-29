package com.six.bean;

import java.util.ArrayList;
import java.util.List;

public class SupplierTableExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public SupplierTableExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andSupplierIdIsNull() {
            addCriterion("Supplier_id is null");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIsNotNull() {
            addCriterion("Supplier_id is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierIdEqualTo(Integer value) {
            addCriterion("Supplier_id =", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotEqualTo(Integer value) {
            addCriterion("Supplier_id <>", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdGreaterThan(Integer value) {
            addCriterion("Supplier_id >", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Supplier_id >=", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLessThan(Integer value) {
            addCriterion("Supplier_id <", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLessThanOrEqualTo(Integer value) {
            addCriterion("Supplier_id <=", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIn(List<Integer> values) {
            addCriterion("Supplier_id in", values, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotIn(List<Integer> values) {
            addCriterion("Supplier_id not in", values, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdBetween(Integer value1, Integer value2) {
            addCriterion("Supplier_id between", value1, value2, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Supplier_id not between", value1, value2, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierNameIsNull() {
            addCriterion("Supplier_name is null");
            return (Criteria) this;
        }

        public Criteria andSupplierNameIsNotNull() {
            addCriterion("Supplier_name is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierNameEqualTo(String value) {
            addCriterion("Supplier_name =", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameNotEqualTo(String value) {
            addCriterion("Supplier_name <>", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameGreaterThan(String value) {
            addCriterion("Supplier_name >", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameGreaterThanOrEqualTo(String value) {
            addCriterion("Supplier_name >=", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameLessThan(String value) {
            addCriterion("Supplier_name <", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameLessThanOrEqualTo(String value) {
            addCriterion("Supplier_name <=", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameLike(String value) {
            addCriterion("Supplier_name like", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameNotLike(String value) {
            addCriterion("Supplier_name not like", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameIn(List<String> values) {
            addCriterion("Supplier_name in", values, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameNotIn(List<String> values) {
            addCriterion("Supplier_name not in", values, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameBetween(String value1, String value2) {
            addCriterion("Supplier_name between", value1, value2, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameNotBetween(String value1, String value2) {
            addCriterion("Supplier_name not between", value1, value2, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierPeopleIsNull() {
            addCriterion("Supplier_people is null");
            return (Criteria) this;
        }

        public Criteria andSupplierPeopleIsNotNull() {
            addCriterion("Supplier_people is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierPeopleEqualTo(String value) {
            addCriterion("Supplier_people =", value, "supplierPeople");
            return (Criteria) this;
        }

        public Criteria andSupplierPeopleNotEqualTo(String value) {
            addCriterion("Supplier_people <>", value, "supplierPeople");
            return (Criteria) this;
        }

        public Criteria andSupplierPeopleGreaterThan(String value) {
            addCriterion("Supplier_people >", value, "supplierPeople");
            return (Criteria) this;
        }

        public Criteria andSupplierPeopleGreaterThanOrEqualTo(String value) {
            addCriterion("Supplier_people >=", value, "supplierPeople");
            return (Criteria) this;
        }

        public Criteria andSupplierPeopleLessThan(String value) {
            addCriterion("Supplier_people <", value, "supplierPeople");
            return (Criteria) this;
        }

        public Criteria andSupplierPeopleLessThanOrEqualTo(String value) {
            addCriterion("Supplier_people <=", value, "supplierPeople");
            return (Criteria) this;
        }

        public Criteria andSupplierPeopleLike(String value) {
            addCriterion("Supplier_people like", value, "supplierPeople");
            return (Criteria) this;
        }

        public Criteria andSupplierPeopleNotLike(String value) {
            addCriterion("Supplier_people not like", value, "supplierPeople");
            return (Criteria) this;
        }

        public Criteria andSupplierPeopleIn(List<String> values) {
            addCriterion("Supplier_people in", values, "supplierPeople");
            return (Criteria) this;
        }

        public Criteria andSupplierPeopleNotIn(List<String> values) {
            addCriterion("Supplier_people not in", values, "supplierPeople");
            return (Criteria) this;
        }

        public Criteria andSupplierPeopleBetween(String value1, String value2) {
            addCriterion("Supplier_people between", value1, value2, "supplierPeople");
            return (Criteria) this;
        }

        public Criteria andSupplierPeopleNotBetween(String value1, String value2) {
            addCriterion("Supplier_people not between", value1, value2, "supplierPeople");
            return (Criteria) this;
        }

        public Criteria andSupplierPhoneIsNull() {
            addCriterion("Supplier_phone is null");
            return (Criteria) this;
        }

        public Criteria andSupplierPhoneIsNotNull() {
            addCriterion("Supplier_phone is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierPhoneEqualTo(String value) {
            addCriterion("Supplier_phone =", value, "supplierPhone");
            return (Criteria) this;
        }

        public Criteria andSupplierPhoneNotEqualTo(String value) {
            addCriterion("Supplier_phone <>", value, "supplierPhone");
            return (Criteria) this;
        }

        public Criteria andSupplierPhoneGreaterThan(String value) {
            addCriterion("Supplier_phone >", value, "supplierPhone");
            return (Criteria) this;
        }

        public Criteria andSupplierPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("Supplier_phone >=", value, "supplierPhone");
            return (Criteria) this;
        }

        public Criteria andSupplierPhoneLessThan(String value) {
            addCriterion("Supplier_phone <", value, "supplierPhone");
            return (Criteria) this;
        }

        public Criteria andSupplierPhoneLessThanOrEqualTo(String value) {
            addCriterion("Supplier_phone <=", value, "supplierPhone");
            return (Criteria) this;
        }

        public Criteria andSupplierPhoneLike(String value) {
            addCriterion("Supplier_phone like", value, "supplierPhone");
            return (Criteria) this;
        }

        public Criteria andSupplierPhoneNotLike(String value) {
            addCriterion("Supplier_phone not like", value, "supplierPhone");
            return (Criteria) this;
        }

        public Criteria andSupplierPhoneIn(List<String> values) {
            addCriterion("Supplier_phone in", values, "supplierPhone");
            return (Criteria) this;
        }

        public Criteria andSupplierPhoneNotIn(List<String> values) {
            addCriterion("Supplier_phone not in", values, "supplierPhone");
            return (Criteria) this;
        }

        public Criteria andSupplierPhoneBetween(String value1, String value2) {
            addCriterion("Supplier_phone between", value1, value2, "supplierPhone");
            return (Criteria) this;
        }

        public Criteria andSupplierPhoneNotBetween(String value1, String value2) {
            addCriterion("Supplier_phone not between", value1, value2, "supplierPhone");
            return (Criteria) this;
        }

        public Criteria andSupplierAddressIsNull() {
            addCriterion("Supplier_address is null");
            return (Criteria) this;
        }

        public Criteria andSupplierAddressIsNotNull() {
            addCriterion("Supplier_address is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierAddressEqualTo(String value) {
            addCriterion("Supplier_address =", value, "supplierAddress");
            return (Criteria) this;
        }

        public Criteria andSupplierAddressNotEqualTo(String value) {
            addCriterion("Supplier_address <>", value, "supplierAddress");
            return (Criteria) this;
        }

        public Criteria andSupplierAddressGreaterThan(String value) {
            addCriterion("Supplier_address >", value, "supplierAddress");
            return (Criteria) this;
        }

        public Criteria andSupplierAddressGreaterThanOrEqualTo(String value) {
            addCriterion("Supplier_address >=", value, "supplierAddress");
            return (Criteria) this;
        }

        public Criteria andSupplierAddressLessThan(String value) {
            addCriterion("Supplier_address <", value, "supplierAddress");
            return (Criteria) this;
        }

        public Criteria andSupplierAddressLessThanOrEqualTo(String value) {
            addCriterion("Supplier_address <=", value, "supplierAddress");
            return (Criteria) this;
        }

        public Criteria andSupplierAddressLike(String value) {
            addCriterion("Supplier_address like", value, "supplierAddress");
            return (Criteria) this;
        }

        public Criteria andSupplierAddressNotLike(String value) {
            addCriterion("Supplier_address not like", value, "supplierAddress");
            return (Criteria) this;
        }

        public Criteria andSupplierAddressIn(List<String> values) {
            addCriterion("Supplier_address in", values, "supplierAddress");
            return (Criteria) this;
        }

        public Criteria andSupplierAddressNotIn(List<String> values) {
            addCriterion("Supplier_address not in", values, "supplierAddress");
            return (Criteria) this;
        }

        public Criteria andSupplierAddressBetween(String value1, String value2) {
            addCriterion("Supplier_address between", value1, value2, "supplierAddress");
            return (Criteria) this;
        }

        public Criteria andSupplierAddressNotBetween(String value1, String value2) {
            addCriterion("Supplier_address not between", value1, value2, "supplierAddress");
            return (Criteria) this;
        }

        public Criteria andSupplierFaxIsNull() {
            addCriterion("Supplier_fax is null");
            return (Criteria) this;
        }

        public Criteria andSupplierFaxIsNotNull() {
            addCriterion("Supplier_fax is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierFaxEqualTo(String value) {
            addCriterion("Supplier_fax =", value, "supplierFax");
            return (Criteria) this;
        }

        public Criteria andSupplierFaxNotEqualTo(String value) {
            addCriterion("Supplier_fax <>", value, "supplierFax");
            return (Criteria) this;
        }

        public Criteria andSupplierFaxGreaterThan(String value) {
            addCriterion("Supplier_fax >", value, "supplierFax");
            return (Criteria) this;
        }

        public Criteria andSupplierFaxGreaterThanOrEqualTo(String value) {
            addCriterion("Supplier_fax >=", value, "supplierFax");
            return (Criteria) this;
        }

        public Criteria andSupplierFaxLessThan(String value) {
            addCriterion("Supplier_fax <", value, "supplierFax");
            return (Criteria) this;
        }

        public Criteria andSupplierFaxLessThanOrEqualTo(String value) {
            addCriterion("Supplier_fax <=", value, "supplierFax");
            return (Criteria) this;
        }

        public Criteria andSupplierFaxLike(String value) {
            addCriterion("Supplier_fax like", value, "supplierFax");
            return (Criteria) this;
        }

        public Criteria andSupplierFaxNotLike(String value) {
            addCriterion("Supplier_fax not like", value, "supplierFax");
            return (Criteria) this;
        }

        public Criteria andSupplierFaxIn(List<String> values) {
            addCriterion("Supplier_fax in", values, "supplierFax");
            return (Criteria) this;
        }

        public Criteria andSupplierFaxNotIn(List<String> values) {
            addCriterion("Supplier_fax not in", values, "supplierFax");
            return (Criteria) this;
        }

        public Criteria andSupplierFaxBetween(String value1, String value2) {
            addCriterion("Supplier_fax between", value1, value2, "supplierFax");
            return (Criteria) this;
        }

        public Criteria andSupplierFaxNotBetween(String value1, String value2) {
            addCriterion("Supplier_fax not between", value1, value2, "supplierFax");
            return (Criteria) this;
        }

        public Criteria andSupplierDescribeIsNull() {
            addCriterion("Supplier_describe is null");
            return (Criteria) this;
        }

        public Criteria andSupplierDescribeIsNotNull() {
            addCriterion("Supplier_describe is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierDescribeEqualTo(String value) {
            addCriterion("Supplier_describe =", value, "supplierDescribe");
            return (Criteria) this;
        }

        public Criteria andSupplierDescribeNotEqualTo(String value) {
            addCriterion("Supplier_describe <>", value, "supplierDescribe");
            return (Criteria) this;
        }

        public Criteria andSupplierDescribeGreaterThan(String value) {
            addCriterion("Supplier_describe >", value, "supplierDescribe");
            return (Criteria) this;
        }

        public Criteria andSupplierDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("Supplier_describe >=", value, "supplierDescribe");
            return (Criteria) this;
        }

        public Criteria andSupplierDescribeLessThan(String value) {
            addCriterion("Supplier_describe <", value, "supplierDescribe");
            return (Criteria) this;
        }

        public Criteria andSupplierDescribeLessThanOrEqualTo(String value) {
            addCriterion("Supplier_describe <=", value, "supplierDescribe");
            return (Criteria) this;
        }

        public Criteria andSupplierDescribeLike(String value) {
            addCriterion("Supplier_describe like", value, "supplierDescribe");
            return (Criteria) this;
        }

        public Criteria andSupplierDescribeNotLike(String value) {
            addCriterion("Supplier_describe not like", value, "supplierDescribe");
            return (Criteria) this;
        }

        public Criteria andSupplierDescribeIn(List<String> values) {
            addCriterion("Supplier_describe in", values, "supplierDescribe");
            return (Criteria) this;
        }

        public Criteria andSupplierDescribeNotIn(List<String> values) {
            addCriterion("Supplier_describe not in", values, "supplierDescribe");
            return (Criteria) this;
        }

        public Criteria andSupplierDescribeBetween(String value1, String value2) {
            addCriterion("Supplier_describe between", value1, value2, "supplierDescribe");
            return (Criteria) this;
        }

        public Criteria andSupplierDescribeNotBetween(String value1, String value2) {
            addCriterion("Supplier_describe not between", value1, value2, "supplierDescribe");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}