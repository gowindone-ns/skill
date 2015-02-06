'use strict';

var searchModule = angular.module('search', []);
searchModule.directive('erpSearch', [ searchUiBuilder ]);

function onsearch($scope, $http, columnAndUrlIndex) {
	$http.get(columnAndUrlIndex).success(
			function(data, status, headers, config) {
				if (data._embedded != undefined) {
					$scope.searchResult = data._embedded.item;
				} else {
					$scope.searchResult = [];
				}
			}).error(function(data, status, headers, config) {
		$scope.searchError = data;
	});
}

function searchController($scope, $http) {

	$scope.onsearch = function(columnAndUrlIndex) {
		onsearch($scope, $http, columnAndUrlIndex)
	}
	$scope.searchResult = [];	
	$scope.onResultRowClick=onResultRowClick;
}

function searchUiBuilder() {
	var builder = {};
	builder.templateUrl = 'components/search/search.html';
	builder.controller = [ '$scope', '$http', searchController ];
	builder.scope = {
		searchColumnsAndUrls : '=filterColumnsAndFilterUrls',
		searchResultColumns : '=columns'
	};
	return builder;

}

function onResultRowClick(resultData){
	alert(resultData.itemName);
}
