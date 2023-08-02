import React, { useState } from 'react';
import { IonItem, IonLabel, IonList } from '@ionic/react';
import { Product } from '../../../model';
import "./Catalog.css"
import { useCatalogContext } from '../../../context';
import { ProductInfo } from '../../ProductInfo';

export interface CatalogProperties {
    products: Product[]
}

const CatalogItem: React.FC<{product: Product, onClick: () => void}> = (props:{product: Product, onClick: () => void}) => (
  <IonItem className="item" onClick={props.onClick}>
    <img src={props.product.picture} className='image'></img>
    <IonLabel>{props.product.name}</IonLabel>
  </IonItem>
);
  


export const Catalog: React.FC<CatalogProperties> = () => {
    const catalogContext = useCatalogContext();
    const [isOpen, setIsOpen] = useState(false);
    const [product, setProduct] = useState<Product>({} as Product)
    const onItemClick = (product: Product) => {
      setProduct(product);
      setIsOpen(true);
    }
    return (
      <>
        <IonList inset={true} className='catalog'>
          {catalogContext.products.map(item => <CatalogItem key={item.id} product={item} onClick={() => onItemClick(item)}/>)}        
        </IonList>
        <ProductInfo product={product} isOpen={isOpen}/>
      </>
    )
}
