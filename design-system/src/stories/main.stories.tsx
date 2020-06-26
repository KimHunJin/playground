import * as React from "react";
import {storiesOf} from "@storybook/react";
import {withKnobs} from "@storybook/addon-knobs";
import * as notes from "./main.md";
import {Form} from "../components/internal";


storiesOf('Main', module)
    .addDecorator(withKnobs)
    .add('main', () => {
            return (
                <div>
                    <Form/>
                </div>
            )
        },
        {
            notes: {
                markdown: notes
            }
        }
    )
