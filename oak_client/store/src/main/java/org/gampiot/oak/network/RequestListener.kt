package org.gampiot.oak.network

import org.gampiot.oak.R

interface RequestListener {
   fun onResponse (tag: String, response: String, responseHeader: HashMap<String, String>)
   fun onErrorResponse (tag: String, response: String)
}