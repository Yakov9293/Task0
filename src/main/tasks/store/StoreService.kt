package main.tasks.store

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.HashMap

class StoreService {
    private val stores = HashMap<String, Store>()
    private val hosts = ArrayList<Host>()
    private val storages = ArrayList<Storage>()

    fun create() {

        //часть в этом блоке для удобного тестирования
        hosts.add(Host("host1"));
        stores.put("store1", Store(hosts.find { host -> host.id == "host1" }));
        storages.add(Storage("storage1"))
        println("Stores: ${stores.map { it.key }}")//как вывести карсиво, типа Мазазин <sName> - владелец <hName>
        println("Hosts: ${hosts.map { it.id }}")
        println("Storage: ${storages.map { it.id }}")
        //дальше продолжаем логику

        val reader = BufferedReader(InputStreamReader(System.`in`))
        commandToProc@ while (true) {
            when (reader.readLine()) {
                "add host" -> hosts.add(Host(reader.readLine()))
                "add store" -> {
                    if (hosts.isNullOrEmpty()) {
                        println("Hosts is empty. Can't create a store...")
                        continue@commandToProc
                    }
                    println("Create id store:")
                    val storeId = reader.readLine()
                    println("Select one host from this list: ${hosts.map { it.id }}")
                    val hostId = reader.readLine();
                    stores.putIfAbsent(storeId, Store(hosts.find { host -> host.id == hostId }))
                }
                "add storage" -> {
                    storages.add(Storage(reader.readLine()))
                }
                "store - storage" -> {
                    println("Choose the store. Enter one of this id's: ${stores.map { it.key }}")
                    val idStore = reader.readLine()
                    println("Choose the storages. Enter one of this id's: ${storages.map { it.id }}")
                    val idStorage = reader.readLine()
                    stores.get(idStore)?.snapStorage(storages.find { store -> store.id == idStorage })//не до окнца понял разницы и смысл !! и ?., но и хер с ним
                }
            }
            println("Stores: ${stores.map { it.key }}")//как вывести карсиво, типа Мазазин <sName> - владелец <hName>
            println("Hosts: ${hosts.map { it.id }}")
            println("Storage: ${storages.map { it.id }}")
        }


    }

}