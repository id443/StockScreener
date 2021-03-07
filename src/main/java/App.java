import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.Interval;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;

public class App {
    public static void main(String[] args) throws IOException {
        Stock stock = YahooFinance.get("DE");

        BigDecimal price = stock.getQuote().getPrice();
        BigDecimal change = stock.getQuote().getChangeInPercent();
        BigDecimal peg = stock.getStats().getPeg();
        BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();

        stock.print();

        Stock tesla = YahooFinance.get("TSLA", true);
        System.out.println(tesla.getHistory());

        Calendar from = Calendar.getInstance();
        Calendar to = Calendar.getInstance();
        from.add(Calendar.YEAR, -5); // from 5 years ago

        Stock google = YahooFinance.get("GOOG", from, to, Interval.WEEKLY);
    }

}
