/* eslint-disable @typescript-eslint/no-unused-vars */
import { createContext, useContext } from "react";
import { Product } from "../model";

const noOpSetProducts = (products: Product[]) => undefined;

export interface CatalogContextType {
    products: Product[];
    setProducts: (products: Product[]) => void
}
export const CatalogContext = createContext<CatalogContextType>({products: [], setProducts: noOpSetProducts});
export const useCatalogContext = () => useContext(CatalogContext);
