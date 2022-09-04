import request from '@/utils/request'

// 查询商家信息增删改列表
export function listShoplist(query) {
  return request({
    url: '/petadmin/shoplist/list',
    method: 'get',
    params: query
  })
}

// 查询商家信息增删改详细
export function getShoplist(id) {
  return request({
    url: '/petadmin/shoplist/' + id,
    method: 'get'
  })
}

// 新增商家信息增删改
export function addShoplist(data) {
  return request({
    url: '/petadmin/shoplist',
    method: 'post',
    data: data
  })
}

// 修改商家信息增删改
export function updateShoplist(data) {
  return request({
    url: '/petadmin/shoplist',
    method: 'put',
    data: data
  })
}

// 删除商家信息增删改
export function delShoplist(id) {
  return request({
    url: '/petadmin/shoplist/' + id,
    method: 'delete'
  })
}
