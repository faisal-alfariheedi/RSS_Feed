//package com.example.rss_feed
//
//import org.xmlpull.v1.XmlPullParser
//import org.xmlpull.v1.XmlPullParserException
//import org.xmlpull.v1.XmlPullParserFactory
//import java.io.IOException
//import java.io.InputStream
//
//class xmlparser {
//    private val stack = ArrayList<Entry>()
//    private var text: String? = null
//
//    private var id =""
//    private var title =""
//    var cat=arrayListOf<String>()
//    var auth=""
//    private var pub = ""
//    var updated = ""
//    var summary =""
//
//
//    fun parse(inputStream: InputStream): ArrayList<Entry> {
//        try {
//            val xmlp = XmlPullParserFactory.newInstance()
//            val parser = xmlp.newPullParser()
//            parser.setInput(inputStream, null)
//            var eventType = parser.eventType
//            while (eventType != XmlPullParser.END_DOCUMENT) {
//                val tagName = parser.name
//                when (eventType) {
//                    XmlPullParser.TEXT -> text = parser.text
//                    XmlPullParser.END_TAG -> when {
//                        tagName.equals("id",ignoreCase = true)->{
//                            id = text.toString()
//                        }
//                        tagName.equals("title", ignoreCase = true) -> {
//                            title =text.toString()
//
//                        }
//                        tagName.equals("category", ignoreCase = true) -> {
//                            cat.add(text.toString())
//                        }
//                        tagName.equals("name", ignoreCase = true) -> {
//                            auth = text.toString()
//                        }
//                        tagName.equals("published", ignoreCase = true) -> {
//                            pub = text.toString()
//                        }
//                        tagName.equals("updated", ignoreCase = true) -> {
//                            updated = text.toString()
//                        }
//                        tagName.equals("summary", ignoreCase = true) -> {
//                            summary = text.toString()
//                        }
//
//                        else ->{ stack.add(Entry ( id,title,cat,auth, pub, updated, summary))
//                            cat.clear()
//                        }
//                    }
//
//                    else -> {
//                    }
//                }
//                eventType = parser.next()
//            }
//
//        } catch (e: XmlPullParserException) {
//            e.printStackTrace()
//        } catch (e: IOException) {
//            e.printStackTrace()
//        }
//        return stack
//    }
//}