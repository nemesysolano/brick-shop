import React, { useState, useEffect } from 'react';
import {
  IonButtons,
  IonButton,
  IonModal,
  IonHeader,
  IonContent,
  IonToolbar,
  IonTitle,
  IonItem,
  IonLabel,
  IonIcon,

} from '@ionic/react';
import { Product } from '../model';
import './ProductInfo.css';
import { arrowBack, cart } from 'ionicons/icons'

export interface ProductInfoProperties {
    product: Product;
    isOpen: boolean,
    onAccept?: (product: Product) => void
}


export const ProductInfo: React.FC<ProductInfoProperties> = (properties: ProductInfoProperties) => {
    const [isOpen, setIsOpen] = useState(false);
    const onToolbarButtonClick = () => setIsOpen(false);    
    useEffect(() => {
        setIsOpen(properties.isOpen)
    }, [properties])
    return (
        <IonModal trigger="open-modal" isOpen={isOpen} className='product-info'>
            <IonHeader>
                <IonToolbar>
                    <IonButtons slot="start">
                        <IonButton onClick={onToolbarButtonClick}>
                            <IonIcon slot="icon-only" icon={arrowBack}></IonIcon>
                        </IonButton>
                    </IonButtons>
                    <IonTitle className="ion-text-center">Product</IonTitle>
                    <IonButtons slot="end">
                        <IonButton onClick={onToolbarButtonClick}>
                            <IonIcon slot="icon-only" icon={cart}></IonIcon>
                        </IonButton>
                    </IonButtons>
                </IonToolbar>
            </IonHeader>
            <IonContent className="ion-padding">
                <IonItem>
                    <img src={properties.product.picture} />
                </IonItem>
                <IonItem>                    
                    <IonLabel className='ion-text-center product-name'>{properties.product.name}</IonLabel>   
                </IonItem>                
                <IonItem>
                    <IonLabel className='ion-text-right padding-right'><span className='hilighted'>{properties.product.price}</span> USD</IonLabel>   
                    <IonLabel className='ion-text-left padding-left'><span className='hilighted'>{properties.product.onHand}</span> on hand</IonLabel>   
                </IonItem>
            </IonContent>
        </IonModal>    
    )
}