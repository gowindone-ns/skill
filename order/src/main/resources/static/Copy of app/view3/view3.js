'use strict';

angular.module('showcase.withScroller',
		[ 'ngRoute', 'datatables', 'datatables.scroller' ]).controller(
		'WithScrollerCtrl', WithScrollerCtrl).config(
		[ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/view3', {
				templateUrl : 'view3/view3.html',
				controller : 'WithScrollerCtrl'
			});
		} ])

function WithScrollerCtrl(DTOptionsBuilder, DTColumnBuilder) {
	var vm = this;
	vm.dtOptions = DTOptionsBuilder.newOptions().withDataProp('data')
			.withDOM('rtiS').withScroller().withOption('serverSide', true)						
			.withOption('deferRender', true).withOption('ajax',function ( data, callback, settings ) {
	            var out = [];
	            
	            for ( var i=data.start, ien=data.start+data.length ; i<ien ; i++ ) {
	                // out.push( [ i+'-1', i+'-2', i+'-3', i+'-4', i+'-5' ] );
	            	out.push({ "idx": i });
	            }
	 
	            setTimeout( function () {
	                callback( {
	                    draw: data.draw,
	                    data: out,
	                    recordsTotal: 5000000,
	                    recordsFiltered: 5000000
	                } );
	            }, 50 );
	        }
					
					)
			// Do not forget to add the scorllY option!!!
			.withOption('scrollY', 200);
	vm.dtColumns = [
			/*DTColumnBuilder.newColumn('_links.self.href')
					.withTitle('Item Code').notSortable().notVisible(),
			DTColumnBuilder.newColumn('itemName').withTitle('Item Name')
					.notSortable().notVisible(),*/
			DTColumnBuilder.newColumn('idx').withTitle('Item Type')];
			// DTColumnBuilder.newColumn('').withTitle('Item Cat') ];
}
