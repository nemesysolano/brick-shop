import * as React from 'react';
import CssBaseline from '@mui/material/CssBaseline';
import Box from '@mui/material/Box';
import Container from '@mui/material/Container';
import { ThemeProvider } from '@mui/material/styles';
import "./Plain.css"
import { defaultTheme } from '../../pages/Theme';
import { Copyright } from './elements';

/* https://blog.logrocket.com/using-react-children-prop-with-typescript/ */

export const Plain:  React.FC<React.PropsWithChildren> = (props: React.PropsWithChildren) => {
  return (
    <ThemeProvider theme={defaultTheme}>
      <Container component="main" maxWidth="xs">
        <CssBaseline />
        <Box
          sx={{
            marginTop: 8,
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
          }}
        >
            {props.children}
        </Box>
        <Copyright sx={{ mt: 8, mb: 4 }} />
      </Container>
    </ThemeProvider>
  );
}