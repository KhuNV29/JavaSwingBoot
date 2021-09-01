app.controller("reports-ctrl", function($scope, $http){
	$scope.account =[];
	$scope.product =[];
	$scope.dashboard =[];
	 $scope.initialize = function(){
		$http.get("/rest/reportsAccount").then(resp =>{
			$scope.account =resp.data;
		})
		$http.get("/rest/reportsProduct").then(resp =>{
			$scope.product =resp.data;
		})
		$http.get("/rest/dashboard").then(resp =>{
			$scope.dashboard =resp.data;
		})
	}
	$scope.initialize();
	$scope.pager={
		page:0,
		size:10,
		get account(){
			var start = this.page * this.size;
			return $scope.account.slice(start, start + this.size);
		},
		get product(){
			var start = this.page * this.size;
			return $scope.product.slice(start, start + this.size);
		},
}
})