package com.example.mvvm_home.api.model

data class VolumeInfo(
    val allowAnonLogging: Boolean,
    val canonicalVolumeLink: String,
    val contentVersion: String,
    val imageLinks: ImageLinks,
    val industryIdentifiers: List<IndustryIdentifier>,
    val infoLink: String,
    val language: String,
    val maturityRating: String,
    val panelizationSummary: PanelizationSummary,
    val previewLink: String,
    val printType: String,
    val publishedDate: String,
    val readingModes: ReadingModes,
    val title: String
)