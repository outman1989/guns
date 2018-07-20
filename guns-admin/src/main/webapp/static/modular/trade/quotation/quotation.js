/**
 * 行情管理初始化
 */
var Quotation = {
    id: "QuotationTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Quotation.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '行情id', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '猪源品类', field: 'productCategory', visible: true, align: 'center', valign: 'middle'},
            {title: '猪源品种', field: 'productVariety', visible: true, align: 'center', valign: 'middle'},
            {title: '价格', field: 'unitPrice', visible: true, align: 'center', valign: 'middle'},
            {title: '所在省', field: 'province', visible: true, align: 'center', valign: 'middle'},
            {title: '所在市', field: 'city', visible: true, align: 'center', valign: 'middle'},
            {title: '所在县区', field: 'area', visible: true, align: 'center', valign: 'middle'},
            {title: '行情日期', field: 'quotationDate', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Quotation.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Quotation.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加行情
 */
Quotation.openAddQuotation = function () {
    var index = layer.open({
        type: 2,
        title: '添加行情',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/quotation/quotation_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看行情详情
 */
Quotation.openQuotationDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '行情详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/quotation/quotation_update/' + Quotation.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除行情
 */
Quotation.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/quotation/delete", function (data) {
            Feng.success("删除成功!");
            Quotation.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("quotationId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询行情列表
 */
Quotation.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Quotation.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Quotation.initColumn();
    var table = new BSTable(Quotation.id, "/quotation/list", defaultColunms);
    // table.setPaginationType("client");//客户端分页
    // table.setPaginationType("server");//服务端分页（默认）
    Quotation.table = table.init();
});
