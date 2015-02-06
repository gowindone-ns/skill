'use strict';

var itemModule = angular.module('erp.item',
		[ 'ngRoute', 'search', 'erp.locale' ]);
itemModule.controller('item', [ '$scope', '$http', 'i18n', itemController ]);
itemModule.config([ '$routeProvider', routeSetup ]);

function routeSetup($routeProvider) {
	$routeProvider.when('/item', {
		templateUrl : 'item/item.html',
		controller : 'item'
	});
}

function itemController($scope, $http, i18n) {

	$scope.columnsItem = [ {
		name : 'itemCategory',
		displayName : i18n.item.category
	}, {
		name : 'itemName',
		displayName : i18n.item.name
	}, {
		name : 'itemType',
		displayName : i18n.item.type
	} ];
	$scope.filterColumnsAndFilterUrlsItem = [ {
		name : 'itemCat',
		url : '/item/search/findByItemCategory?itemCategory='
	}, {
		name : 'itemName',
		url : '/item/search/findByItemName?itemName='
	} ];

}
