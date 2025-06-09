module.exports = {
  content: [
    "./src/**/*.{clj,cljs,cljc}",
    "./public/**/*.html"
  ],
  theme: {
    extend: {
      colors: {
        'primary': 'var(--color-text)',
        'secondary': 'var(--color-text-subdued)',
        'surface': 'var(--color-testimonials-bg)',
      },
      fontFamily: {
        'sans': 'var(--font-sans)',
        'mono': 'var(--font-mono)',
      },
      width: {
        '120': '30rem',
        '144': '36rem',
      },
      height: {
        '80': '20rem',
        '96': '24rem',
      }
    },
  },
  safelist: [
    // Responsive classes for testimonials layout
    'sm:grid-cols-2',
    'lg:flex-row',
    'lg:items-center', 
    'lg:gap-12',
    'lg:px-8',
    'lg:w-144',
    'lg:h-96',
    'xl:mx-0',
    'xl:max-w-none',
    'xl:grid-cols-4',
    'xl:contents',
    'xl:space-y-0',
    'xl:row-span-2',
    'xl:row-start-1',
    'xl:grid-flow-col',
    // Projects grid responsive classes
    'md:grid-cols-2',
    'lg:grid-cols-3',
    // Color classes
    'text-primary',
    'text-secondary',
    'bg-surface',
    // Additional classes for projects
    'bg-opacity-50',
    'bg-opacity-75',
    'hover:bg-opacity-75',
    'hover:text-primary',
    'btn-sm',
    'target:_blank',
    'ring-primary',
    // Footer responsive classes
    'md:flex-row',
    'md:justify-between',
    'md:items-center',
    'md:flex-wrap',
    // Social link pseudo-element classes
    'before:content-[var(--emoji)]',
    'before:mr-1',
    'before:no-underline',
    // Project carousel classes
    'scrollbar-hide',
    'line-clamp-2',
    'flex-shrink-0',
    'h-[40vh]',
    'md:h-[50vh]'
  ],
  plugins: [],
}