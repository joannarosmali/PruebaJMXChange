
package com.test.xchange;

import java.io.IOException;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.binance.BinanceExchange;
import org.knowm.xchange.bitstamp.BitstampExchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.service.marketdata.MarketDataService;

/**
 * @author jmangarre
 *
 */
public class PruebaJMXChange {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Exchange bitstamp = ExchangeFactory.INSTANCE.createExchange(BitstampExchange.class.getName());
		//Exchange bitstamp = ExchangeFactory.INSTANCE.createExchange(BinanceExchange.class.getName());

		Exchange binancestamp = ExchangeFactory.INSTANCE.createExchange(new BinanceExchange().getDefaultExchangeSpecification());
		//MarketDataService marketDataService = bitstamp.getMarketDataService();

		//Ticker ticker;
		try {
			//ticker = marketDataService.getTicker(CurrencyPair.BTC_USD);
			System.out.println(getTicker(bitstamp.getMarketDataService(), CurrencyPair.BTC_USD).toString());
			System.out.println(getTicker(binancestamp.getMarketDataService(), CurrencyPair.BTC_USD).toString());
			
			/*BitstampTicker bitstampTicker = ((BitstampMarketDataServiceRaw)marketDataService).getBitstampTicker(CurrencyPair.BTC_USD);
			System.out.println(bitstampTicker.toString());*/
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static Ticker getTicker (MarketDataService marketDataService, CurrencyPair currencyPair) throws IOException{
		return marketDataService.getTicker(currencyPair);
	}

}
