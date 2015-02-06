'use strict';

var searchModule = angular.module('search', [ 'ngRoute' ]);
searchModule.controller('search',['$scope','$http',search]);
searchModule.directive('erpSearch', [searchUiBuilder]);
searchModule.config([ '$routeProvider', routeSetup]);

function routeSetup($routeProvider) {
	$routeProvider.when('/view5', {
		templateUrl : 'view5/view5.html',
		controller : 'search'
	});
}

function onsearch($scope,$http){	
	$http.get('/item/search/findByItemCategory?itemCategory=' + $scope.searchItemName).
	  success(function(data, status, headers, config) {
		  if(data._embedded != undefined ){
			  $scope.searchResult = data._embedded.item;
		  }else{
			  $scope.searchResult = [];
		  }
	  }).
	  error(function(data, status, headers, config) {
		  $scope.searchError=data;
	  });
}


function search($scope,$http) {

	$scope.onsearch=function(){onsearch($scope,$http)}
	$scope.searchItemName='ITMCAT 9999';	
	$scope.searchResult=[];
	$scope.resultCol=['itemName','itemCategory','itemType']
	onsearch($scope,$http);
}

function searchUiBuilder() {
	var builder = {};	
	builder.templateUrl = 'view5/comp/search.html';	
	builder.controller=search;	
	return builder;

}
