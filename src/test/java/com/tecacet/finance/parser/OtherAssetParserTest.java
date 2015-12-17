package com.tecacet.finance.parser;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.Test;

import com.tecacet.finance.model.Asset;
import com.tecacet.finance.model.AssetType;
import com.tecacet.finance.model.Exchange;

public class OtherAssetParserTest {

	@Test
	public void testParse() throws IOException {
		OtherAssetParser parser = new OtherAssetParser();
		String file = "nasdaqtrader" + File.separator + "otherlisted.txt";
		InputStream is = this.getClass().getClassLoader().getResourceAsStream(file);
		List<Asset> assets = parser.parse(is);
		assertEquals(5229, assets.size());

		// A|Agilent Technologies, Inc. Common Stock|N|A|N|100|N|A
		Asset first = assets.get(0);
		assertEquals("A", first.getSymbol());
		assertEquals("Agilent Technologies, Inc. Common Stock", first.getName());
		assertEquals(Exchange.NYSE, first.getExchange());
		assertEquals(100, first.getRoundLotSize());
		assertEquals(AssetType.STOCK, first.getAssetType());
	}

}
