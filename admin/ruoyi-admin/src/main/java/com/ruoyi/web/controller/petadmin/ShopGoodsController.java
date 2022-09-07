package com.ruoyi.web.controller.petadmin;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.petshop.domain.ShopGoods;
import com.ruoyi.petshop.service.IShopGoodsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品管理Controller
 *
 * @author ruoyi
 * @date 2022-09-07
 */
@RestController
@RequestMapping("/shop/goods")
public class ShopGoodsController extends BaseController
{
    @Autowired
    private IShopGoodsService shopGoodsService;

    /**
     * 查询商品管理列表
     */
    @PreAuthorize("@ss.hasPermi('shop:goods:list')")
    @GetMapping("/list")
    public TableDataInfo list(ShopGoods shopGoods)
    {
        startPage();
        List<ShopGoods> list = shopGoodsService.selectShopGoodsList(shopGoods);
        return getDataTable(list);
    }

    /**
     * 导出商品管理列表
     */
    @PreAuthorize("@ss.hasPermi('shop:goods:export')")
    @Log(title = "商品管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ShopGoods shopGoods)
    {
        List<ShopGoods> list = shopGoodsService.selectShopGoodsList(shopGoods);
        ExcelUtil<ShopGoods> util = new ExcelUtil<ShopGoods>(ShopGoods.class);
        util.exportExcel(response, list, "商品管理数据");
    }

    /**
     * 获取商品管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('shop:goods:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(shopGoodsService.selectShopGoodsById(id));
    }

    /**
     * 新增商品管理
     */
    @PreAuthorize("@ss.hasPermi('shop:goods:add')")
    @Log(title = "商品管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ShopGoods shopGoods)
    {
        return toAjax(shopGoodsService.insertShopGoods(shopGoods));
    }

    /**
     * 修改商品管理
     */
    @PreAuthorize("@ss.hasPermi('shop:goods:edit')")
    @Log(title = "商品管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ShopGoods shopGoods)
    {
        return toAjax(shopGoodsService.updateShopGoods(shopGoods));
    }

    /**
     * 删除商品管理
     */
    @PreAuthorize("@ss.hasPermi('shop:goods:remove')")
    @Log(title = "商品管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(shopGoodsService.deleteShopGoodsByIds(ids));
    }
}
