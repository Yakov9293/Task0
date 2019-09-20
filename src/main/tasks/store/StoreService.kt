package main.tasks.store

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class StoreService {
    private val stores = ArrayList<Store>()
    private val hosts = ArrayList<Host>()

    fun create() {
        val reader = BufferedReader(InputStreamReader(System.`in`))
        while (true) {
            when (reader.readLine()) {
                "add host" -> hosts.add(Host(reader.readLine()))
                "add store" -> {
                    val hostId = reader.readLine();
                    stores.add(Store(hosts.find { host -> host.id == hostId }))
                }
            }
            println("Stores: ${stores.map { it.host.id }}")
            println("Hosts: ${hosts.map { it.id }}")
        }


    }

}