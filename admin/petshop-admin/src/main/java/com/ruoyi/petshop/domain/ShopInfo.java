package com.ruoyi.petshop.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商家信息增删改对象 shop_info
 *
 * @author bobo
 * @date 2022-08-31
 */
public class ShopInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 店铺id */
    private Long id;

    /** 店铺名 */
    @Excel(name = "店铺名")
    private String shopName;

    /** 店铺头像 */
    @Excel(name = "店铺头像")
    private String shopImg;

    /** 店铺评分 */
    @Excel(name = "店铺评分")
    private Long shopStar;

    /** 店铺所在省份 */
    @Excel(name = "店铺所在省份")
    private String shopProvince;

    /** 店铺所在城市 */
    @Excel(name = "店铺所在城市")
    private String shopCity;

    /** 店铺所在街道 */
    @Excel(name = "店铺所在街道")
    private String shopStreet;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public String getShopName()
    {
        return shopName;
    }
    public void setShopImg(String shopImg)
    {
        this.shopImg = shopImg;
    }

    public String getShopImg()
    {
        return shopImg;
    }
    public void setShopStar(Long shopStar)
    {
        this.shopStar = shopStar;
    }

    public Long getShopStar()
    {
        return shopStar;
    }
    public void setShopProvince(String shopProvince)
    {
        this.shopProvince = shopProvince;
    }

    public String getShopProvince()
    {
        return shopProvince;
    }
    public void setShopCity(String shopCity)
    {
        this.shopCity = shopCity;
    }

    public String getShopCity()
    {
        return shopCity;
    }
    public void setShopStreet(String shopStreet)
    {
        this.shopStreet = shopStreet;
    }

    public String getShopStreet()
    {
        return shopStreet;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("shopName", getShopName())
            .append("shopImg", getShopImg())
            .append("shopStar", getShopStar())
            .append("shopProvince", getShopProvince())
            .append("shopCity", getShopCity())
            .append("shopStreet", getShopStreet())
            .toString();
    }
}
