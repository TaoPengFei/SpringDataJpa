//ajax请求json数据
function ajaxRequest(url,data,sourceFlag,callbackFlag,callbackHandler){
    $.ajax({
        url:url,
        type:"POST",
        data:data,
        headers : {
            'Content-Type' : 'application/json;charset=UTF-8',
            'Accept': 'application/json'
        },
        dataType:"json",
        timeout:900000,
        error:function(XMLHttpRequest, textStatus, errorThrown){
            // alert("Error posting data!");
            // alert(textStatus);
            // alert(XmlHttpRequest.responseText);
        },
        success:function(result){
            callbackHandler(sourceFlag,callbackFlag,result);
        }
    });
}

function submitForm(form, exra, callback, methods, captions) {
    var $form = null;
    if(typeof(form)=="string"){
        $form = $("#"+form);
    }
    else if(typeof(form)=="object"){
        $form = $(form);
    }
    else{
        return false;
    }
    var url = $form.attr("action");
    //if(url) {
    //url += ((url.indexOf("?")== -1)?"?":"&") + "_rm=" + new Date().getTime();
    //}
    var param = $form.serializeArray();
    var params = [];
    if(exra){
        $.each(param, function (i, obj) {
            for(var item in exra){
                if(this.name == item) {
                    //多选下拉框删除数据会造成数据缺少
                    //param.splice(i,1);
                    this.name = '';
                    this.value = '';
                }
            }
        });
        for(var item in param) {
//                console.log(param[item]["name"] + ":" + param[item]["value"] + ":" + typeof(param[item]["value"]))
            if(param[item]["name"] != "") {
                params.push({name:param[item]["name"],value:param[item]["value"]});
            }
        }
        for(var item in exra){
            //console.log(param.name)
            //param.push({name:item,value:exra[item]});
            params.push({name:item,value:exra[item]});
        }
    } else {
        params = param;
    }
    if(callback){
        if(methods){
            //for(var item in methods) {
            $.each(methods, function (item, obj) {
                $.ajax({
                    type: "post",
                    url: url  + "/" + methods[item] + "?_rm=" + new Date().getTime(),
                    data: params,
                    dataType: "json",
                    success: function (json) {
                        callback(methods[item],captions[item],json);
                    }
                });
                //}
            });
        }
        else{
            $.ajax({
                type: "post",
                url: url,
                data: param,
                dataType: "json",
                success: function (json) {
                    callback(json);
                }
            });
        }
    }
    return false;
}

//********************************************************************************************************************
function getSelectedYear(){
    var year = $("#cmbYear").multiselect("getChecked").map(function(){
        return this.value;
    }).get().join(",");
    return year.toString();
}

function getSelectedMonth(){
    var month = $("#cmbMonth").multiselect("getChecked").map(function(){
        return this.value;
    }).get().join(",");
    return month.toString();
}

function getSelectedDay(){
    var month = $("#cmbDay").multiselect("getChecked").map(function(){
        return this.value;
    }).get().join(",");
    return month.toString();
}

function getSelectedHour(){
    var month = $("#cmbHh").multiselect("getChecked").map(function(){
        return this.value;
    }).get().join(",");
    return month.toString();
}

function getSelectedQy(){
    var result = $("#cmbQy").multiselect("getChecked").map(function(){
        return this.value;
    }).get().join(",");
    return result.toString();
}

function getSelectedJz(){
    var result = $("#cmbJz").multiselect("getChecked").map(function(){
        return this.value;
    }).get().join(",");
    return result.toString();
}
function getSelectedPcs(){
    var result = $("#cmbPcs").multiselect("getChecked").map(function(){
        return this.value;
    }).get().join(",");
    return result.toString();
}
function getSelectedRoad1(){
    var result = $("#cmbRoad1").multiselect("getChecked").map(function(){
        return this.value;
    }).get().join(",");
    return result.toString();
}
function getSelectedJcw(){
    var result = $("#cmbJcw").multiselect("getChecked").map(function(){
        return this.value;
    }).get().join(",");
    return result.toString();
}

function getSelectedBjay1(){
    var result = $("#cmbBjay1").multiselect("getChecked").map(function(){
        return this.value;
    }).get().join(",");
    return result.toString();
}

function getSelectedBjay2(){
    var result = $("#cmbBjay2").multiselect("getChecked").map(function(){
        return this.value;
    }).get().join(",");
    return result.toString();
}    //******************************************************************************************************************
function addParamArea(formId,jsonObj,url){
    var year = getSelectedYear();
    if(year!=""){
        jsonObj.year = year.split(",");
    }
    var month = getSelectedMonth();
    if(month!=""){
        jsonObj.month = month.split(",");
    }
    var day = getSelectedDay();
    if(day!=""){
        jsonObj.day = day;
    }
    var hour = getSelectedHour();
    if(hour!=""){
        jsonObj.hh = hour;
    }
    var qy = getSelectedQy();
    if(qy!=""){
        jsonObj.qy = qy.split(",");
    }
    var jz = getSelectedJz();
    if(jz!=""){
        jsonObj.jz = jz.split(",");
    }
    var pcs = getSelectedPcs();
    if(pcs!=""){
        jsonObj.pcs = pcs.split(",");
    }
    var jcw = getSelectedJcw();
    if(jcw!=""){
        jsonObj.jcw = jcw.split(",");
    }
    submitFormToIframe(formId,jsonObj,url);
}

function addParamDwlb(formId,jsonObj,url){
    var year = getSelectedYear();
    if(year!=""){
        jsonObj.year = year.split(",");
    }
    var month = getSelectedMonth();
    if(month!=""){
        jsonObj.month = month.split(",");
    }
    var day = getSelectedDay();
    if(day!=""){
        jsonObj.day = day;
    }
    var hour = getSelectedHour();
    if(hour!=""){
        jsonObj.hh = hour;
    }
    var dwlb1 = $("#cmbDwlb1 :selected").val();
    if(dwlb1!=""&&dwlb1!=undefined){
        jsonObj.dwlb1 = dwlb1;
    }
    var dwlb2 = $("#cmbDwlb2 :selected").val();
    if(dwlb2!=""&&dwlb2!=undefined){
        jsonObj.dwlb2 = dwlb2;
    }
    var dwlb3 = $("#cmbDwlb3 :selected").val();
    if(dwlb3!=""&&dwlb3!=undefined){
        jsonObj.dwlb3 = dwlb3;
    }
    var dwlb4 = $("#cmbDwlb4 :selected").val();
    if(dwlb4!=""&&dwlb4!=undefined){
        jsonObj.dwlb4 = dwlb4;
    }
    submitFormToIframe(formId,jsonObj,url);
}

function addParamDwlbAndBjay(formId,jsonObj,url){
    var year = getSelectedYear();
    if(year!=""){
        jsonObj.year = year.split(",");
    }
    var month = getSelectedMonth();
    if(month!=""){
        jsonObj.month = month.split(",");
    }
    var day = getSelectedDay();
    if(day!=""){
        jsonObj.day = day;
    }
    var hour = getSelectedHour();
    if(hour!=""){
        jsonObj.hh = hour;
    }
    var dwlb1 = $("#cmbDwlb1 :selected").val();
    if(dwlb1!=""){
        jsonObj.dwlb1 = dwlb1;
    }
    var dwlb2 = $("#cmbDwlb2 :selected").val();
    if(dwlb1!=""){
        jsonObj.dwlb2 = dwlb2;
    }
    var dwlb3 = $("#cmbDwlb3 :selected").val();
    if(dwlb1!=""){
        jsonObj.dwlb3 = dwlb3;
    }
    var dwlb4 = $("#cmbDwlb4 :selected").val();
    if(dwlb1!=""){
        jsonObj.dwlb4 = dwlb4;
    }
    var bjay1 = $("#cmbBjay1 :selected").val();
    if(bjay1!=""){
        jsonObj.bjay1 = bjay1;
    }
    var bjay2 = $("#cmbBjay2 :selected").val();
    if(bjay2!=""){
        jsonObj.bjay2 = bjay2;
    }
    submitFormToIframe(formId,jsonObj,url);
}

function addParamSdandCs(formId,jsonObj,url){
    var year = getSelectedYear();
    if(year!=""){
        jsonObj.year = year.split(",");
    }
    var month = getSelectedMonth();
    if(month!=""){
        jsonObj.month = month.split(",");
    }
    var day = getSelectedDay();
    if(day!=""){
        jsonObj.day = day;
    }
    submitFormToIframe(formId,jsonObj,url);

}

function submitFormToIframe(form, params, url) {
    var $build = $("<form style='display: none;'></form>");
//        var mid;
//        if(params.wtcs_flag&&params.wtcs_flag==1){
//            if(url.indexOf("place_analysis_report")>0){
//                mid = 81;
//            }else if(url.indexOf("place_employee_report")>0){
//                mid = 82;
//            }else{
//                mid = 83;
//            }
//        }else{
//            if(url.indexOf("place_analysis_report")>0){
//                mid = 21;
//            }else if(url.indexOf("place_employee_report")>0){
//                mid = 23;
//            }else{
//                mid = 25;
//            }
//        }
    $build.attr('action', url);
    $build.attr('method', 'post');
    $build.attr('target','_blank');
    for(var item in params){
        var keyValue = params[item];
        if(typeof (keyValue)=="object"){
            for(var i = 0 ; i < keyValue.length ; i++){
                var m_input = $('<input type="text" />');
                m_input.attr('name', item);
                m_input.attr('value', keyValue[i]);
                $build.append(m_input);
            }
        }else if(typeof (keyValue)=="string"||typeof (keyValue)=="number"){
            var m_input = $('<input type="text" />');
            m_input.attr('name', item);
            m_input.attr('value', keyValue);
            $build.append(m_input);
        }else{
            return false;
        }
    }
    $build.appendTo("body");
    $build.submit();
    $build.remove();
}