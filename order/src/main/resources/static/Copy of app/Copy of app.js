'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
  'datatables',
  'datatables.scroller',
  'search',
  'myApp.view1',
  'myApp.view2',
  'showcase.withScroller',
  'myApp.version'
]).
config(['$routeProvider', function($routeProvider) {
  $routeProvider.otherwise({redirectTo: '/view1'});
  
}]);
