new Vue({
	el:'#admin_top_list',
	data:{
		pages:[
			["../LibrarySystem/admin_Users.html",""],
			["../LibrarySystem/admin_Books.html",""],
			["../LibrarySystem/admin_Borrow.html",""],
			["../LibrarySystem/admin_Return.html",""],
			["../LibrarySystem/admin.html",""]
		]
	},
	methods:{
		change:function (did) {
			//AdminSelectUsers.selectRequest();
			window.location.href=this.pages[did][0];
		}
	}
	
})


//发送请求
var AdminSelectUsers=new Vue({
	el:'#admin_middle_table_Users',
	data: function(){
		var url="/LibrarySystem/AdminAllUsers";
		axios.get(url).then(function(response){
			alert("do it");
			var rows=eval('('+response.request.responseText+')');
			return {rows};
		});
	},
})

