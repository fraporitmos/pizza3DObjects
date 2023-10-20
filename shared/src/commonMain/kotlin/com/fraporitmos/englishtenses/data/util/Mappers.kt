package com.fraporitmos.englishtenses.data.util

import com.fraporitmos.englishtenses.domain.model.Pizza
import com.fraporitmos.englishtenses.data.remote.PizzaRemote


internal fun PizzaRemote.toPizza(): Pizza {
    return Pizza(
        id = id,
        name = name,
        desc = desc,
        img = img,
        obj_android = obj_android,
        obj_ios = obj_ios,
        price = price
    )
}
