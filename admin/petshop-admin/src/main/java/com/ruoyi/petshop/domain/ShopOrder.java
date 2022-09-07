package com.ruoyi.petshop.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * order对象 shop_order
 *
 * @author ruoyi
 * @date 2022-09-07
 */
public class ShopOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String orderNo;

    /** 订单状态：
 0： 已下单（待支付）
 1： 已支付（代发货）
 2： 已发货（待收货）
 3： 已收货（待评价）
 4： 已评价
 -1：取消订单
-2：申请退单
-3：管理员审核通过
-4：管理员直接退单 */
    @Excel(name = "订单状态")
    private Long status;

    /** 商品数量 */
    @Excel(name = "商品数量")
    private Long productCount;

    /** 总价 */
    @Excel(name = "总价")
    private BigDecimal totalPrice;

    /** 收货地址 */
    @Excel(name = "收货地址")
    private String addressId;

    /** 下单用户ID */
    @Excel(name = "下单用户ID")
    private Long userId;

    /** 下单商品id */
    @Excel(name = "下单商品id")
    private Long goodsId;

    /** 下单时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "下单时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderTime;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setOrderNo(String orderNo)
    {
        this.orderNo = orderNo;
    }

    public String getOrderNo()
    {
        return orderNo;
    }
    public void setStatus(Long status)
    {
        this.status = status;
    }

    public Long getStatus()
    {
        return status;
    }
    public void setProductCount(Long productCount)
    {
        this.productCount = productCount;
    }

    public Long getProductCount()
    {
        return productCount;
    }
    public void setTotalPrice(BigDecimal totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPrice()
    {
        return totalPrice;
    }
    public void setAddressId(String addressId)
    {
        this.addressId = addressId;
    }

    public String getAddressId()
    {
        return addressId;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setGoodsId(Long goodsId)
    {
        this.goodsId = goodsId;
    }

    public Long getGoodsId()
    {
        return goodsId;
    }
    public void setOrderTime(Date orderTime)
    {
        this.orderTime = orderTime;
    }

    public Date getOrderTime()
    {
        return orderTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderNo", getOrderNo())
            .append("status", getStatus())
            .append("productCount", getProductCount())
            .append("totalPrice", getTotalPrice())
            .append("addressId", getAddressId())
            .append("userId", getUserId())
            .append("goodsId", getGoodsId())
            .append("orderTime", getOrderTime())
            .toString();
    }
}
