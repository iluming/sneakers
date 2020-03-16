$(function(){
    var vue = new Vue({
        el: '#inputApply',
        data: {
            uri:'InputApply/listInputApply',
            inputApplies: [],
            pages:[]
        },
        mounted:function(){
            this.list(1);
        },
        methods: {
            list:function(pageNo){
                var url =  this.uri + "?pageNo="+pageNo;
                axios.get(url).then(function(response) {
                    vue.inputApplies = response.data.listApplyPage;
                    vue.pages =  response.data.inputApplyPageInfo;
                });
            },
            jump: function(page){
                jumpPage(page,vue);
            },
            jumpByNumber: function(start){
                jumpNum(start,vue);
            }

        }
    });



});