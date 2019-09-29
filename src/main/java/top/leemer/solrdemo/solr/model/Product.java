package top.leemer.solrdemo.solr.model;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.io.Serializable;

/**
 * @author LEEMER
 * Create Date: 2019-09-15
 */
@SolrDocument(collection = "product")
public class Product implements Serializable {

    @Id
    private Long id;

    @Field("product_name")
    @Indexed
    private String productName;

    @Field("selling_price")
    @Indexed
    private double sellingPrice;

    @Field("category")
    @Indexed
    private String category;

    @Field("remark")
    @Indexed
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
