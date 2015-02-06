'use strict';

angular.module('showcase.withScroller',
		[ 'ngRoute', 'datatables', 'datatables.scroller' ]).controller(
		'WithTableCtrl', WithTableCtrl).config(
		[ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/view4', {
				templateUrl : 'view4/view4.html',
				controller : 'WithTableCtrl'
			});
		} ])

function WithTableCtrl() {
	$(document).ready(function() {
	    $('#example').DataTable( {
	        serverSide: true,
	        ordering: true,
	        searching: true,
	       
	        ajax:{url:"/item",dataSrc:function(json){ var r={}; r.data=json._embedded.item;r.recordsTotal=10000;r.recordsFiltered=10000; 
	        
	        return r; }}
	        /*
	        ajax: function ( data, callback, settings ) {
	        	// alert('i am clicked.');
	            var out = [];
	 
	            for ( var i=data.start, ien=data.start+data.length ; i<ien ; i++ ) {
	                out.push( [ i+'-1', i+'-2', i+'-3', i+'-4', i+'-5' ] );
	            }
	 
	            setTimeout( function () {
	                callback( {
	                    draw: data.draw,
	                    data: out,
	                    recordsTotal: 100000,
	                    recordsFiltered: 100000
	                } );
	            }, 50 );
	        }*/
	        ,
	        dom: "rtiS",
	        scrollY: 300,
	        scroller: {
	            loadingIndicator: true
	        }
	    } );
	} );
	
}
