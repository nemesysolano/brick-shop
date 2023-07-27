import React from 'react';
import { IonItem, IonLabel, IonList } from '@ionic/react';
import { Product } from '../../../model';
import "./Catalog.css"
import { useCatalogContext } from '../../../context';

export interface CatalogProperties {
    products: Product[]
}

const CatalogItem: React.FC<Product> = (product: Product) => (
  <IonItem key={product.id}>
    <img src={product.picture} className='image'></img>
    <IonLabel>{product.name}</IonLabel>
  </IonItem>
);
  


export const Catalog: React.FC<CatalogProperties> = () => {
    const catalogContext = useCatalogContext();

    return (
      <IonList inset={true} className='catalog'>
        {catalogContext.products.map(CatalogItem)}        
      </IonList>
    )
}
