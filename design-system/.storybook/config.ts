import {addDecorator, configure} from '@storybook/react';
import {withA11y} from '@storybook/addon-a11y';

import "../src/components/polyfills";

// automatically import all files ending in *.stories.tsx
const req = require.context('../src/stories', true, /\.stories\.tsx$/);

function loadStories() {
    req.keys().forEach(req);
}

addDecorator(withA11y);

configure(loadStories, module);
