import React from 'react';
import './FakeStockTicker.css';

class FakeStockTicker extends React.Component {
	render() {
		
		var marqueeContents = ' ';
		for (let i = 0; i < 60; i++) {
			marqueeContents += Math.random().toString(36).replace(/[^a-z]+/g, '').substr(0, 3).toUpperCase();
			marqueeContents += Math.random() > 0.5 ? '↑' : '↓';
			marqueeContents += (Math.random() * 10).toFixed(2);
			marqueeContents += ' ';
		}
		
		return (
			<div 
				className='fake-stock-ticker'
			>
				<b>{marqueeContents}</b>
			</div>
		);
	}
};
export default FakeStockTicker;