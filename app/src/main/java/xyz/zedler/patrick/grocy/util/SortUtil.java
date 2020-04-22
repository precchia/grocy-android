package xyz.zedler.patrick.grocy.util;

import java.util.Collections;
import java.util.List;

import xyz.zedler.patrick.grocy.model.Product;
import xyz.zedler.patrick.grocy.model.StockItem;
import xyz.zedler.patrick.grocy.model.StockLocation;

public class SortUtil {

    public static void sortStockItemsByName(List<StockItem> stockItems, boolean ascending) {
        if(stockItems == null) return;
        Collections.sort(
                stockItems,
                (item1, item2) -> (ascending ? item1 : item2).getProduct().getName().compareTo(
                        (ascending ? item2 : item1).getProduct().getName()
                )
        );
    }

    public static void sortStockItemsByBBD(List<StockItem> stockItems, boolean ascending) {
        if(stockItems == null) return;
        Collections.sort(
                stockItems,
                (item1, item2) -> {
                    String bbd1 = (ascending ? item1 : item2).getBestBeforeDate();
                    String bbd2 = (ascending ? item2 : item1).getBestBeforeDate();
                    if(bbd1 == null && bbd2 == null) {
                        return 0;
                    } else if(bbd1 == null) {
                        return -1; // or 1 when items without BBD should be last
                    } else if(bbd2 == null) {
                        return 1; // or -1 when items without BBD should be last
                    }
                    return DateUtil.getDate(bbd1).compareTo(DateUtil.getDate(bbd2));
                }
        );
    }

    public static void sortProductsByName(List<Product> products, boolean ascending) {
        if(products == null) return;
        Collections.sort(
                products,
                (item1, item2) -> (ascending ? item1 : item2).getName().compareTo(
                        (ascending ? item2 : item1).getName()
                )
        );
    }

    public static void sortStockLocationItemsByName(List<StockLocation> stockLocations) {
        if(stockLocations == null) return;
        Collections.sort(
                stockLocations,
                (item1, item2) -> item1.getLocationName().compareTo(item2.getLocationName())
        );
    }
}