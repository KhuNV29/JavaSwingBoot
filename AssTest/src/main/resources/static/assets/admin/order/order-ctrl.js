app.controller("order-ctrl", function($scope, $http){
	alert("Order")
	$scope.unresolved = [];
	$scope.processing = [];
	$scope.processed = [];
	$scope.completed = [];
	$scope.form ={};
	$scope.initialize = function(){
		$http.get("/rest/unresolved").then(resp =>{
			$scope.unresolved =resp.data;
			$scope.unresolved.forEach(item => {
                item.createDate = new Date(item.createDate)
            })
		})
		$http.get("/rest/processing").then(resp =>{
			$scope.processing =resp.data;
			$scope.processing.forEach(item => {
                item.createDate = new Date(item.createDate)
            })
		})
		$http.get("/rest/processed").then(resp =>{
			$scope.processed =resp.data;
			$scope.processed.forEach(item => {
                item.createDate = new Date(item.createDate)
            })
		})
		$http.get("/rest/completed").then(resp =>{
			$scope.completed =resp.data;
			$scope.completed.forEach(item => {
                item.createDate = new Date(item.createDate)
            })
		})
	}
	$scope.initialize();
	
	$scope.updateProcessing=function(item){
		$http.put(`/rest/order/processing/${item.id}`,item).then(resp =>{
			$scope.initialize();
			alert("Cập nhật thành công")
		})
	}
	$scope.updateProcessed=function(item){
		$http.put(`/rest/order/processed/${item.id}`,item).then(resp =>{
			$scope.initialize();
			alert("Cập nhật thành công")
		})
	}
	$scope.updateCompleted=function(item){
		$http.put(`/rest/order/completed/${item.id}`,item).then(resp =>{
			$scope.initialize();
			alert("Cập nhật thành công")
		})
	}
	
	$scope.pager={
		page:0,
		size:50,
		get unresolved(){
			var start = this.page * this.size;
			return $scope.unresolved.slice(start, start + this.size);
		},
		get count(){
			return Math.ceil(1.0*$scope.unresolved.length/this.size)
		},
		fisrt(){
			this.page=0;
		},
		prev(){
			this.page--;
			if(this.page<0){
				this.last();
			}
		},
		next(){
			this.page++;
			if(this.page>=this.count){
				this.first();
			}
		},
		last(){
			this.page = this.count-1;
		}
	
}
})