'use strict';

var searchModule = angular.module('erp.locale', []);
searchModule.factory('i18n', [ i18nService ]);

function i18nService() {
	this.dictionary = {};
	this.dictionary.item = {};
	this.dictionary.item.name = "Item Name";
	this.dictionary.item.type = "Item Type";
	this.dictionary.item.category = "Item Category";
	this.dictionary.item.code = "Item Code";
	
	return this.dictionary;
}
