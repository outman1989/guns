package com.stylefeng.guns.modular.system.model;

import java.lang.annotation.Native;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 行情
 * </p>
 *
 * @author stylefeng
 * @since 2018-07-16
 */
@TableName("quotation")
public class Quotation extends Model<Quotation> {

    private static final long serialVersionUID = 1L;

    /**
     * 行情id
     */
    @TableId(value = "id", type = IdType.INPUT)
    private String id;
    /**
     * 猪源品类
     */
    @TableField("product_category")
    private String productCategory;
    /**
     * 猪源品种
     */
    @TableField("product_variety")
    private String productVariety;
    /**
     * 价格
     */
    @TableField("unit_price")
    private BigDecimal unitPrice;
    /**
     * 所在省
     */
    private String province;
    /**
     * 所在市
     */
    private String city;
    /**
     * 所在县区
     */
    private String area;
    /**
     * 行情日期
     */
    @TableField("quotation_date")
    private String quotationDate;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductVariety() {
        return productVariety;
    }

    public void setProductVariety(String productVariety) {
        this.productVariety = productVariety;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getQuotationDate() {
        return quotationDate;
    }

    public void setQuotationDate(String quotationDate) {
        this.quotationDate = quotationDate;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Quotation{" +
        "id=" + id +
        ", productCategory=" + productCategory +
        ", productVariety=" + productVariety +
        ", unitPrice=" + unitPrice +
        ", province=" + province +
        ", city=" + city +
        ", area=" + area +
        ", quotationDate=" + quotationDate +
        "}";
    }
}
