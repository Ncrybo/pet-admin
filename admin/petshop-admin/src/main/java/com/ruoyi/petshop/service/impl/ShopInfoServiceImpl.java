package com.ruoyi.petshop.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.petshop.mapper.ShopInfoMapper;
import com.ruoyi.petshop.domain.ShopInfo;
import com.ruoyi.petshop.service.IShopInfoService;

/**
 * 商家信息增删改Service业务层处理
 *
 * @author bobo
 * @date 2022-08-31
 */
@Service
public class ShopInfoServiceImpl implements IShopInfoService
{
    @Autowired
    private ShopInfoMapper shopInfoMapper;

    /**
     * 查询商家信息增删改
     *
     * @param id 商家信息增删改主键
     * @return 商家信息增删改
     */
    @Override
    public ShopInfo selectShopInfoById(Long id)
    {
        return shopInfoMapper.selectShopInfoById(id);
    }

    /**
     * 查询商家信息增删改列表
     *
     * @param shopInfo 商家信息增删改
     * @return 商家信息增删改
     */
    @Override
    public List<ShopInfo> selectShopInfoList(ShopInfo shopInfo)
    {
        return shopInfoMapper.selectShopInfoList(shopInfo);
    }

    /**
     * 新增商家信息增删改
     *
     * @param shopInfo 商家信息增删改
     * @return 结果
     */
    @Override
    public int insertShopInfo(ShopInfo shopInfo)
    {
        return shopInfoMapper.insertShopInfo(shopInfo);
    }

    /**
     * 修改商家信息增删改
     *
     * @param shopInfo 商家信息增删改
     * @return 结果
     */
    @Override
    public int updateShopInfo(ShopInfo shopInfo)
    {
        return shopInfoMapper.updateShopInfo(shopInfo);
    }

    /**
     * 批量删除商家信息增删改
     *
     * @param ids 需要删除的商家信息增删改主键
     * @return 结果
     */
    @Override
    public int deleteShopInfoByIds(Long[] ids)
    {
        return shopInfoMapper.deleteShopInfoByIds(ids);
    }

    /**
     * 删除商家信息增删改信息
     *
     * @param id 商家信息增删改主键
     * @return 结果
     */
    @Override
    public int deleteShopInfoById(Long id)
    {
        return shopInfoMapper.deleteShopInfoById(id);
    }
}
