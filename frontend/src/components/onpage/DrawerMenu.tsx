import React from 'react';
import { ListItemButton, ListItemIcon, ListItemText } from '@mui/material';
import Category from '@mui/icons-material/Category';
import ReceiptLong from '@mui/icons-material/ReceiptLong';

export const DrawerMenu:React.FC = () => (
    <React.Fragment>
    <ListItemButton>
      <ListItemIcon>
        <Category />
      </ListItemIcon>
      <ListItemText primary="Catalog" />
    </ListItemButton>
    <ListItemButton>
      <ListItemIcon>
        <ReceiptLong />
      </ListItemIcon>
      <ListItemText primary="Orders" />
    </ListItemButton>
  </React.Fragment>
)