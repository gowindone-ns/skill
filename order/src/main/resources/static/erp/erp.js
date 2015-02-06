'use strict';

// Declare app level module which depends on views, and components
angular.module('erp', [
  'ngRoute', 
  'search',
  'erp.locale',
  'erp.order',
  'erp.item', 
]).
config(['$routeProvider', function($routeProvider) {
  $routeProvider.otherwise({redirectTo: '/order'});
  
}]);
