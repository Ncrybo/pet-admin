package com.ruoyi.web.controller.petadmin;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.petshop.domain.ShopInfo;
import com.ruoyi.petshop.service.IShopInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 商家信息增删改Controller
 *
 * @author bobo
 * @date 2022-08-31
 */
@RestController
@RequestMapping("/petadmin/shoplist")
public class ShopInfoController extends BaseController
{
    @Autowired
    private IShopInfoService shopInfoService;

    /**
     * 查询商家信息增删改列表
     */
    @PreAuthorize("@ss.hasPermi('petadmin:shoplist:list')")
    @GetMapping("/list")
    public TableDataInfo list(ShopInfo shopInfo)
    {
        startPage();
        List<ShopInfo> list = shopInfoService.selectShopInfoList(shopInfo);
        return getDataTable(list);
    }

    /**
     * 导出商家信息增删改列表
     */
    @PreAuthorize("@ss.hasPermi('petadmin:shoplist:export')")
    @Log(title = "商家信息增删改", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ShopInfo shopInfo)
    {
        List<ShopInfo> list = shopInfoService.selectShopInfoList(shopInfo);
        ExcelUtil<ShopInfo> util = new ExcelUtil<ShopInfo>(ShopInfo.class);
        util.exportExcel(response, list, "商家信息增删改数据");
    }

    /**
     * 获取商家信息增删改详细信息
     */
    @PreAuthorize("@ss.hasPermi('petadmin:shoplist:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(shopInfoService.selectShopInfoById(id));
    }

    /**
     * 新增商家信息增删改
     */
    @PreAuthorize("@ss.hasPermi('petadmin:shoplist:add')")
    @Log(title = "商家信息增删改", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ShopInfo shopInfo)
    {
        return toAjax(shopInfoService.insertShopInfo(shopInfo));
    }

    /**
     * 修改商家信息增删改
     */
    @PreAuthorize("@ss.hasPermi('petadmin:shoplist:edit')")
    @Log(title = "商家信息增删改", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ShopInfo shopInfo)
    {
        return toAjax(shopInfoService.updateShopInfo(shopInfo));
    }

    /**
     * 删除商家信息增删改
     */
    @PreAuthorize("@ss.hasPermi('petadmin:shoplist:remove')")
    @Log(title = "商家信息增删改", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(shopInfoService.deleteShopInfoByIds(ids));
    }
}
