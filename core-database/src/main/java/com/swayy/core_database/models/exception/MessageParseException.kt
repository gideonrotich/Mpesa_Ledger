package com.swayy.core_database.models.exception

class MessageParseException(override val message: String, val body: String) : Exception(message)