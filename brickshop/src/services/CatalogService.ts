import axios from "axios";
import { Product } from "../model";

const SERVICE_HOST = "http://192.168.1.142:8080";
export class CatalogService {
    static async getProducts(): Promise<Product[]> {
        const products = await axios.get<Product[]>(`${SERVICE_HOST}/product/all`)        
        return products.data;
    }
}