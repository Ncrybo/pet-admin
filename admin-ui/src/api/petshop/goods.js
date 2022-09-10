import request from '@/utils/request'

// 查询商品管理列表
export function listGoods(query) {
  return request({
    url: '/shop/goods/list',
    method: 'get',
    params: query
  })
}

// 查询商品管理详细
export function getGoods(id) {
  return request({
    url: '/shop/goods/' + id,
    method: 'get'
  })
}

// 新增商品管理
export function addGoods(data) {
  return request({
    url: '/shop/goods',
    method: 'post',
    data: data
  })
}

// 修改商品管理
export function updateGoods(data) {
  return request({
    url: '/shop/goods',
    method: 'put',
    data: data
  })
}

// 删除商品管理
export function delGoods(id) {
  return request({
    url: '/shop/goods/' + id,
    method: 'delete'
  })
}
