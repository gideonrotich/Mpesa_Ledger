package com.swayy.core_database.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.swayy.core_database.models.TransactionType

@ProvidedTypeConverter
class Converters {
    @TypeConverter
    fun fromTransactionType(transactionType: TransactionType): String {
        return transactionType.name
    }

    @TypeConverter
    fun fromString(string: String): TransactionType {
        return TransactionType.valueOf(string)
    }
}
