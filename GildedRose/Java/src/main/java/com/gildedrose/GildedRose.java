package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item actualItem = items[i];
            if (actualItem.isNotMainItem()) {
                updateByNotMainItem(actualItem);
            } else {
                updateMainItem(actualItem);
            }
            if (!actualItem.name.equals("Sulfuras, Hand of Ragnaros")) {
                actualItem.sellIn = actualItem.sellIn - 1;
            }
            updateItemBySellIn(actualItem);
        }
    }

    private void updateMainItem(Item actualItem) {
        if (actualItem.quality < 50) {
            actualItem.quality = actualItem.quality + 1;
            if (actualItem.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (actualItem.sellIn < 11) {
                    updateByFiftyQuality(actualItem);
                }
                if (actualItem.sellIn < 6) {
                    updateByFiftyQuality(actualItem);
                }
            }
        }
    }

    private void updateByFiftyQuality(Item actualItem) {
        if (actualItem.quality < 50) {
            actualItem.quality = actualItem.quality + 1;
        }
    }

    private void updateItemBySellIn(Item actualItem) {
        if (actualItem.sellIn < 0) {
            if (actualItem.isNotMainItem()) {
                updateByNotMainItem(actualItem);
                actualItem.quality = 0;
            }
            updateByFiftyQuality(actualItem);
        }
    }
    private void updateByNotMainItem(Item actualItem) {
        if (actualItem.quality > 0 ) {
            actualItem.quality = actualItem.quality - 1;
        }
    }
}
