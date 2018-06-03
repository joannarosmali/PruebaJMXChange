
package com.test.xchange;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.ExchangeSpecification;
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

		//Exchange binancestamp = ExchangeFactory.INSTANCE.createExchange(BinanceExchange.class.getName());
		ExchangeSpecification exSpec = new BinanceExchange().getDefaultExchangeSpecification();
		exSpec.setExchangeSpecificParametersItem("recvWindow", 10000L);
		Exchange binancestamp = ExchangeFactory.INSTANCE.createExchange(exSpec);

		//ticker = marketDataService.getTicker(CurrencyPair.BTC_USD);
		System.out.println("Bitstamp --> "+getTicker(bitstamp.getMarketDataService(), CurrencyPair.BTC_USD).toString());
		
		System.out.println("Binance  --> "+getTicker(binancestamp.getMarketDataService(), CurrencyPair.BTC_USD));

	}

	private static Ticker getTicker (MarketDataService marketDataService, CurrencyPair currencyPair)/* throws IOException*/{
		try {
			return marketDataService.getTicker(currencyPair);
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

}
