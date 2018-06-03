
package com.test.xchange;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.binance.BinanceExchange;
import org.knowm.xchange.binance.service.BinanceMarketDataService;
import org.knowm.xchange.bitstamp.BitstampExchange;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.meta.CurrencyMetaData;
import org.knowm.xchange.dto.meta.CurrencyPairMetaData;
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
		/*ExchangeSpecification exSpec = new BinanceExchange().getDefaultExchangeSpecification();
		exSpec.setExchangeSpecificParametersItem("recvWindow", 10000L);
		Exchange binancestamp = ExchangeFactory.INSTANCE.createExchange(exSpec);*/
		//BinanceMarketDataService bmds = new BinanceMarketDataService(binancestamp);
		Exchange exchange = ExchangeFactory.INSTANCE.createExchange(BinanceExchange.class.getName());
		//MarketDataService marketService = (BinanceMarketDataService) exchange.getMarketDataService();
		//BinanceMarketDataService marketDataService = (BinanceMarketDataService) exchange.getMarketDataService();

		//ticker = marketDataService.getTicker(CurrencyPair.BTC_USD);
		System.out.println("Bitstamp --> "+getTicker(bitstamp.getMarketDataService(), CurrencyPair.BTC_USD).toString());
		
		System.out.println("Binance  --> "+getTicker(exchange.getMarketDataService(), CurrencyPair.BTC_USDT));
		
		/*try {

			Map<CurrencyPair, CurrencyPairMetaData> currencies = exchange.getExchangeMetaData().getCurrencyPairs();
			System.out.println("currencies "+currencies);
			System.out.println("currencie "+CurrencyPair.BTC_USDT+" -> "+currencies.get(CurrencyPair.BTC_USDT));
			//System.out.println("-- "+exchange.getExchangeSpecification().getApiKey());
			System.out.println("marketDataService.getTimestamp(); :: "+marketDataService.getTimestamp());
			System.out.println("Binance  --> "+marketDataService.getTicker(CurrencyPair.BTC_USDT));
		} catch (IOException e) {
			//e.printStackTrace();
			//System.out.println(e.getMessage());
		}*/

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
