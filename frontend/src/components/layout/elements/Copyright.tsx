import { Link, Typography } from '@mui/material';
import React from 'react';

export const Copyright: React.FC<any> = (props: any) => (
    <Typography variant="body2" color="text.secondary" align="center" {...props}>
      {'Copyright © '}
      <Link color="inherit" href="https://mui.com/">
        Your Website
      </Link>{' '}
      {new Date().getFullYear()}
      {'.'}
    </Typography>
  );    
