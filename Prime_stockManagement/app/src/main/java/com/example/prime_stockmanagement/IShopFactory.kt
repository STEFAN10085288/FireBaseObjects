package com.example.prime_stockmanagement

class ShopFactory {

    fun  makeShop(type: ShopType): IShop?{
        return when(type) {
            ShopType.Checkers -> Checkers()
            ShopType.Shoprite -> Shoprite()
            else -> null
        }
    }
    }
