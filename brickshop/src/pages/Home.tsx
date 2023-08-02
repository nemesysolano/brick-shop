import React from 'react';
import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar } from '@ionic/react';
import './Home.css';
import { Catalog } from '../components/listing/catalog/Catalog';

const Home: React.FC = () => {
  return (
    <IonPage>
      <IonHeader>
        <IonToolbar>
          <IonTitle className='ion-text-center'>Product Catalog</IonTitle>
        </IonToolbar>
      </IonHeader>
      <IonContent fullscreen>
        <Catalog products={[]} />
      </IonContent>
    </IonPage>
  );
};

export default Home;
