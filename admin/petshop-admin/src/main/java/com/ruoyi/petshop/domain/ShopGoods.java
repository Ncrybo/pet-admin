package com.ruoyi.petshop.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品管理对象 shop_goods
 * 
 * @author ruoyi
 * @date 2022-09-07
 */
public class ShopGoods extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商品id */
    private Long id;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String goodsName;

    /** 所属商店 */
    @Excel(name = "所属商店")
    private String shopName;

    /** 商品图片 */
    @Excel(name = "商品图片")
    private String img;

    /** 售价 */
    @Excel(name = "售价")
    private Long price;

    /** 描述 */
    @Excel(name = "描述")
    private String describes;

    /** 库存 */
    @Excel(name = "库存")
    private Long amount;

    /** 类型 */
    @Excel(name = "类型")
    private Long type;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setGoodsName(String goodsName) 
    {
        this.goodsName = goodsName;
    }

    public String getGoodsName() 
    {
        return goodsName;
    }
    public void setShopName(String shopName) 
    {
        this.shopName = shopName;
    }

    public String getShopName() 
    {
        return shopName;
    }
    public void setImg(String img) 
    {
        this.img = img;
    }

    public String getImg() 
    {
        return img;
    }
    public void setPrice(Long price) 
    {
        this.price = price;
    }

    public Long getPrice() 
    {
        return price;
    }
    public void setDescribes(String describes) 
    {
        this.describes = describes;
    }

    public String getDescribes() 
    {
        return describes;
    }
    public void setAmount(Long amount) 
    {
        this.amount = amount;
    }

    public Long getAmount() 
    {
        return amount;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("goodsName", getGoodsName())
            .append("shopName", getShopName())
            .append("img", getImg())
            .append("price", getPrice())
            .append("describes", getDescribes())
            .append("amount", getAmount())
            .append("type", getType())
            .toString();
    }
}
