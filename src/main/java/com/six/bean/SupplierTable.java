package com.six.bean;

import java.io.Serializable;

/**
 * supplier_table
 * @author 
 */
public class SupplierTable implements Serializable {
    private Integer supplierId;

    private String supplierName;

    private String supplierPeople;

    private String supplierPhone;

    private String supplierAddress;

    private String supplierFax;

    private String supplierDescribe;

    private static final long serialVersionUID = 1L;

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierPeople() {
        return supplierPeople;
    }

    public void setSupplierPeople(String supplierPeople) {
        this.supplierPeople = supplierPeople;
    }

    public String getSupplierPhone() {
        return supplierPhone;
    }

    public void setSupplierPhone(String supplierPhone) {
        this.supplierPhone = supplierPhone;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierFax() {
        return supplierFax;
    }

    public void setSupplierFax(String supplierFax) {
        this.supplierFax = supplierFax;
    }

    public String getSupplierDescribe() {
        return supplierDescribe;
    }

    public void setSupplierDescribe(String supplierDescribe) {
        this.supplierDescribe = supplierDescribe;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SupplierTable other = (SupplierTable) that;
        return (this.getSupplierId() == null ? other.getSupplierId() == null : this.getSupplierId().equals(other.getSupplierId()))
            && (this.getSupplierName() == null ? other.getSupplierName() == null : this.getSupplierName().equals(other.getSupplierName()))
            && (this.getSupplierPeople() == null ? other.getSupplierPeople() == null : this.getSupplierPeople().equals(other.getSupplierPeople()))
            && (this.getSupplierPhone() == null ? other.getSupplierPhone() == null : this.getSupplierPhone().equals(other.getSupplierPhone()))
            && (this.getSupplierAddress() == null ? other.getSupplierAddress() == null : this.getSupplierAddress().equals(other.getSupplierAddress()))
            && (this.getSupplierFax() == null ? other.getSupplierFax() == null : this.getSupplierFax().equals(other.getSupplierFax()))
            && (this.getSupplierDescribe() == null ? other.getSupplierDescribe() == null : this.getSupplierDescribe().equals(other.getSupplierDescribe()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSupplierId() == null) ? 0 : getSupplierId().hashCode());
        result = prime * result + ((getSupplierName() == null) ? 0 : getSupplierName().hashCode());
        result = prime * result + ((getSupplierPeople() == null) ? 0 : getSupplierPeople().hashCode());
        result = prime * result + ((getSupplierPhone() == null) ? 0 : getSupplierPhone().hashCode());
        result = prime * result + ((getSupplierAddress() == null) ? 0 : getSupplierAddress().hashCode());
        result = prime * result + ((getSupplierFax() == null) ? 0 : getSupplierFax().hashCode());
        result = prime * result + ((getSupplierDescribe() == null) ? 0 : getSupplierDescribe().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", supplierId=").append(supplierId);
        sb.append(", supplierName=").append(supplierName);
        sb.append(", supplierPeople=").append(supplierPeople);
        sb.append(", supplierPhone=").append(supplierPhone);
        sb.append(", supplierAddress=").append(supplierAddress);
        sb.append(", supplierFax=").append(supplierFax);
        sb.append(", supplierDescribe=").append(supplierDescribe);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}